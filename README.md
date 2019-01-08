# newspicksClone
- ニュースのキュレーションサイトのクローン
- ユーザはニュースのURLを入力し、pick(= ニュースと思っていただいて構いません)を作成できる。
- ユーザはpickに対して１つだけコメントを残すことができます。
- ユーザは気に入ったコメントに対して「いいね」できます。
- ユーザは任意のキーワードを複数登録できます。
- ニュース（pick）は複数のテーマにカテゴライズされます。

# newspicksClone
## テーブル設計

### usersテーブル

|Column|Type|Options|
|------|----|-------|
|first_name|string|null: false, index: true|
|last_name|string|null:false, index:true|
|company|string||
|position|string||
|profile|text||
|image|string|

#### Relationship
- has_many :picks, through :picks_users
- has_many :picks_users
- has_many :comments
- has_many :keywords

### picksテーブル

|Column|Type|Options|
|------|----|-------|
|url|string|null: false, unique: true|
|image|string|null: false|
|title|string|null: false, index: true|
|body|text|null: false, index: true|
|source|string|null: false|

#### Relationship
- has_many :comments
- has_many :users, through :picks_users
- has_many :picks_users
- has_many :themes, through :picks_themes
- has_many :picks_themes

### commentsテーブル

|Column|Type|Options|
|------|----|-------|
|comments|text|index: true|
|pick_id|references|null: false, foreign_key: true|
|user_id|references|null: false, foreign_key: true|

#### Relationship
- belongs_to :pick
- belongs_to :user

### likesテーブル

|Column|Type|Options|
|------|----|-------|
|comment_id|references|null: false, foreign_key: true|
|user_id|references|null: false, foreign_key: true|

#### Relationship
- belongs_to :comment
- belongs_to :user

### keywordsテーブル

|Column|Type|Options|
|------|----|-------|
|keyword|string|null:false|
|user_id|references|null: false, foreign_key: true|

#### Relationship
- belongs_to :user


### themesテーブル

|Column|Type|Options|
|------|----|-------|
|theme|string|null: false|

#### Relationship
- has_many :picks, through :picks_themes
- has_many :picks_themes

### picks_themesテーブル

|Column|Type|Options|
|------|----|-------|
|pick_id|references|null: false, foreign_key: true|
|theme_id|references|null: false, foreign_key: true|

#### Relationship
- belongs_to :pick
- belongs_to :theme
