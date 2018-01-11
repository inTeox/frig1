 
-- -----------------------------------------------------
-- Table `mydb`.`proprietaire`
-- -----------------------------------------------------
 --DROP TABLE    proprietaire ;


CREATE  TABLE    proprietaire (
  idproprietaire int GENERATED ALWAYS AS IDENTITY,
  nomProprietaire VARCHAR(45)   ,
  prenomProprietaire VARCHAR(45)   ,
  emailProprietaire VARCHAR(200)   ,  
  telephoneProprietaire varchar(10),
  adresse1Proprietaire VARchar (200),
  adresse2Proprietaire VARCHAR (200),
  cpproprietaire NUMERIC (5),
  villeProprietaire VARCHAR (200),
  pseudoProprietaire VARCHAR(45)   ,
  motPasseProprietaire VARCHAR(45)   ,
  dddebut DATE   ,
  ddfin DATE   ,
  PRIMARY KEY (idproprietaire) );


-- -----------------------------------------------------
-- Table `mydb`.`Frigo`
-- -----------------------------------------------------
--DROP TABLE    frigo ;

CREATE  TABLE     frigo (
  idFrigo int GENERATED ALWAYS AS IDENTITY,
  nom VARCHAR(45)   ,
  idProprietaire INT  NOT NULL  ,
  dddebut DATE   ,
  ddfin DATE   ,
  PRIMARY KEY (idFrigo) ,
   CONSTRAINT FK_POSSEDE FOREIGN KEY (idProprietaire)
      REFERENCES proprietaire (idProprietaire) ON DELETE RESTRICT ON UPDATE RESTRICT
    )
   
;


-- -----------------------------------------------------
-- Table `mydb`.`categorieAliment`
-- -----------------------------------------------------
--DROP TABLE   categorieAliment ;

CREATE  TABLE   categorieAliment (
  idcategorieAliment int GENERATED ALWAYS AS IDENTITY,
  nomCategorie VARCHAR(45)   ,
  dddebut DATE   ,
  ddfin DATE   ,
  PRIMARY KEY (idcategorieAliment) )
 ;


-- -----------------------------------------------------
-- Table `mydb`.`Aliment`
-- -----------------------------------------------------
--DROP TABLE    aliment ;

CREATE  TABLE    aliment (
  idAliment int GENERATED ALWAYS AS IDENTITY,
  nomAliment VARCHAR(45)   ,
  description VARCHAR(45)   ,
  dddebut DATE   ,
  ddfin DATE   ,
  idcategorieAliment INT NOT NULL ,
  PRIMARY KEY (idAliment),
  CONSTRAINT FK_ESTCATEGORIE FOREIGN KEY (idcategorieAliment)
      REFERENCES categorieAliment (idcategorieAliment) ON DELETE RESTRICT ON UPDATE RESTRICT
) 
   ;


-- -----------------------------------------------------
-- Table `mydb`.`Frigo_has_Aliment`
-- -----------------------------------------------------
--DROP TABLE   frigo_has_Aliment ;

CREATE  TABLE   frigo_has_Aliment (
   idFrigoHasAliment int GENERATED ALWAYS AS IDENTITY,
  idFrigo INT NOT NULL ,
  idAliment INT NOT NULL ,
  qteAliment INT   ,
  dddebut DATE   ,
  ddfin DATE   ,
  PRIMARY KEY (idFrigoHasAliment),
  CONSTRAINT FK_ESTDANSFRIGO FOREIGN KEY (idFrigo)
      REFERENCES frigo (idFrigo) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_ALMESTDANSFRIGO FOREIGN KEY (idAliment)
      REFERENCES aliment (idAliment) ON DELETE RESTRICT ON UPDATE RESTRICT
) 
  ;


-- -----------------------------------------------------
-- Table `mydb`.`typeRecette`
-- -----------------------------------------------------
--DROP TABLE   typeRecette ;

CREATE  TABLE   typeRecette (
  idtypeRecette int GENERATED ALWAYS AS IDENTITY,
  nomType VARCHAR(45)   ,
  dddebut DATE   ,
  ddfin DATE   ,
  PRIMARY KEY (idtypeRecette) )
;


-- -----------------------------------------------------
-- Table `mydb`.`recette`
-- -----------------------------------------------------
--DROP TABLE   recette ;

CREATE  TABLE   recette (
  idrecette int GENERATED ALWAYS AS IDENTITY,
  origineRecette VARCHAR(45)   ,
  description_recette BLOB   ,
  dddebut DATE   ,
  ddfin DATE   ,
  idtypeRecette INT NOT NULL ,
  PRIMARY KEY (idrecette) ,
  CONSTRAINT FK_ESTTYPERECETTE FOREIGN KEY (idtypeRecette)
      REFERENCES typeRecette (idtypeRecette) ON DELETE RESTRICT ON UPDATE RESTRICT
)
  ;


-- -----------------------------------------------------
-- Table `mydb`.`Aliment_has_recette`
-- -----------------------------------------------------
--DROP TABLE   aliment_has_recette ;

CREATE  TABLE   aliment_has_recette (
  idAlimentHasRecette int GENERATED ALWAYS AS IDENTITY,
  idAliment INT NOT NULL ,
  idrecette INT NOT NULL ,
  PRIMARY KEY (idAlimentHasRecette) ,
CONSTRAINT FK_ESTDANSRECETTE FOREIGN KEY (idAliment)
      REFERENCES aliment (idAliment) ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT FK_RECETTE FOREIGN KEY (idrecette)
      REFERENCES recette (idrecette) ON DELETE RESTRICT ON UPDATE RESTRICT
 )
  ;

