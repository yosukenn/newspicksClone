CREATE TABLE picks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  url VARCHAR(255) NOT NULL,
  image_url VARCHAR(255),
  title VARCHAR(255) NOT NULL,
  body VARCHAR(255),
  source VARCHAR(255)
);
ALTER TABLE picks ADD CONSTRAINT user_unique UNIQUE(url);
CREATE INDEX title_index ON picks(title, body);
