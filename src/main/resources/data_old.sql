-- Pour la table Utilisateur
CREATE SEQUENCE IF NOT EXISTS user_sequence START WITH 1 INCREMENT BY 1;

-- Pour la table Plat
CREATE SEQUENCE IF NOT EXISTS plat_sequence START WITH 1 INCREMENT BY 1;

-- Pour la table Allergene
CREATE SEQUENCE IF NOT EXISTS allergene_sequence START WITH 1 INCREMENT BY 1;

-- Pour la table Commande
CREATE SEQUENCE IF NOT EXISTS commande_sequence START WITH 1 INCREMENT BY 1;

-- Pour la table Panier
CREATE SEQUENCE IF NOT EXISTS panier_sequence START WITH 1 INCREMENT BY 1;

-- Pour la table Plat_Panier
CREATE SEQUENCE IF NOT EXISTS plat_panier_sequence START WITH 1 INCREMENT BY 1;

-- Pour la table Plat_Commande
CREATE SEQUENCE IF NOT EXISTS plat_commande_sequence START WITH 1 INCREMENT BY 1;


-- Insertion de données dans la table Utilisateur
INSERT INTO Utilisateur (username, password, nom, prenom, solde_crous) VALUES
                                                                           ('jdoe', 'password123', 'John', 'Doe', 100),
                                                                           ('asmith', 'password123', 'Alice', 'Smith', 150),
                                                                           ('mjones', 'password123', 'Michael', 'Jones', 200);

-- Insertion de données dans la table Plat
INSERT INTO Plat (nom, description, prix, image_url, categorie) VALUES
                                                                    ('Pizza Margherita', 'Simple mais délicieux', 12, 'url1', 'Pizza'),
                                                                    ('Ravioli', 'Pâtes farcies à la ricotta', 15, 'url2', 'Pâtes'),
                                                                    ('Steak Frites', 'Classique français', 18, 'url3', 'Viande');

-- Insertion de données dans la table Allergene
INSERT INTO Allergene (nom) VALUES
                                ('Gluten'),
                                ('Arachide'),
                                ('Lactose');

-- Insertion de données dans la table Commande
INSERT INTO Commande (user_id, adresse_livraison, status, date_commande) VALUES
                                                                             (1, '123 Rue ABC', 'Livré', '2023-08-31'),
                                                                             (2, '456 Rue DEF', 'En préparation', '2023-08-30');

-- Insertion de données dans la table Panier
INSERT INTO Panier (user_id) VALUES
                                 (1),
                                 (2),
                                 (3);

-- Insertion de données dans la table Plat_Panier
INSERT INTO Plat_Panier (plat_id, panier_id, quantite) VALUES
                                                           (1, 1, 2),
                                                           (2, 2, 1),
                                                           (3, 3, 2);

-- Insertion de données dans la table Plat_Commande
INSERT INTO Plat_Commande (plat_id, commande_id, quantite) VALUES
                                                               (1, 1, 1),
                                                               (2, 2, 2),
                                                               (3, 1, 1);