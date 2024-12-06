/**
 * @author The Hai Nguyen - December 06, 2024
 */

--Insert book data for testing
INSERT INTO BOOK (title, authors) VALUES
    ('Caraval', 'S. Garber'),
    ('Sapiens', 'Yuval Noah Harari'),
    ('Frankenstein', 'Mary Shelley'),
    ('Inferno', 'Dante Alighieri'),
    ('Dracula', 'Bram Stoker');

--Insert review data for testing
INSERT INTO REVIEW (book_id, review) VALUES
    (1, 'The book is great'),
    (1, 'Excellent'),
    (2, 'The most interesting book I have ever read'),
    (2, 'Very nice book'),
    (3, 'Must read!!!');

--Add 1 user in the database
INSERT INTO MY_USER_DETAILS (username, password, roles) VALUES
    ('Jane', 'pass', 'USER');
