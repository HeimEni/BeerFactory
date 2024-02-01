CREATE TABLE FACTORY (
    idFactory INT AUTO_INCREMENT PRIMARY KEY,
    nameFactory VARCHAR(50) NOT NULL,
    address VARCHAR(50),
    latitude FLOAT,
    longitude FLOAT,
    openDate DATE
);

CREATE TABLE BEER (
    idBeer INT AUTO_INCREMENT PRIMARY KEY,
    nameBeer VARCHAR(50) NOT NULL,
    typeBeer VARCHAR(50),
    description VARCHAR(255),
    alcoholPercentage FLOAT,
    evaluation FLOAT,
    idFactory INT,
    CONSTRAINT fk_id_factory FOREIGN KEY (idFactory)REFERENCES FACTORY(idFactory)
);

INSERT INTO FACTORY (idFactory, nameFactory, address, latitude, longitude, openDate) VALUES ('1','nomFactory','addressFactory','185.15','-4545.45','2000-12-12');
INSERT INTO BEER (idBeer, nameBeer, typeBeer, description, alcoholPercentage, evaluation,idFactory) VALUES ('1','nameBeer','TypeBeer','description','100','10','1');