/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  theha
 * Created: Dec 2, 2024
 */
INSERT INTO BOOK (title, authors) VALUES
    ('Caraval', 'S. Garber'),
    ('Sapiens', 'Yuval Noah Harari'),
    ('Frankenstein', 'Mary Shelley'),
    ('Inferno', 'Dante Alighieri'),
    ('Dracula', 'Bram Stoker');

INSERT INTO REVIEW (book_id, review) VALUES
    (1, 'The book is great'),
    (1, 'Excellent'),
    (2, 'The most interesting book I have ever read'),
    (2, 'Very nice book'),
    (3, 'Must read!!!');

INSERT INTO MY_USER_DETAILS (username, password, roles) VALUES
    ('Jane', 'pass', 'USER');
