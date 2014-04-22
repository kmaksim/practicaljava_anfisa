CONNECT 'jdbc:derby://localhost:1527/Lesson22;create=true';

CREATE TABLE Portfolio (
  id int NOT NULL,
  symbol VARCHAR(10) NOT NULL,
  quantity FLOAT NOT NULL,
  price FLOAT NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO Portfolio (id,symbol,quantity,price) values (1, 'IBM', 500, 105.50);

INSERT INTO Portfolio (id,symbol,quantity,price) values (2, 'AMZN', 1000, 15.25);

INSERT INTO Portfolio (id,symbol,quantity,price) values  (3, 'AAPL', 2000, 272.50);
