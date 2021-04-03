# Memòria del projecte M6/M7
Data: 2021-04-03

Alumnes:

- Edgar Luque Prados
- Kevin Fernandez Muñoz

\pagebreak

## Funcionalitat
Es una aplicació per mantenir una llista de clients i els videojocs que han comprat.

## Justificació del disseny
L'aplicació està feta al voltant de les dos classes principals que representen el Client i el Videogame.

Per aixó, aquestes dues clases necessiten un DAO especialitzat: ClientDao i VideoGameDAO; que extenen la interficíe DAO que conté els metodes comuns del disseny CRUD.

Tenim 3 tipus d'excepcions:

- NotFoundException: Quan un objecte no és pot trobar, s'utilitza aquesta excepció en comptes de retornar null perque és més explícit.
- DuplicatedException: Quan s'intenta inserir un objecte amb una id duplicada.
- DatabaseException: Aquesta excepció es per qualsevol error intern que pugui tenir la base de dades.

\pagebreak

## Mockup / Captures de pantalla

![](./mockup.png)

\pagebreak

## Diagrama classes UML/E-R

### Package com.github
![](./com.github.svg)

### Package com.github.db
![](./com.github.db.svg)

### Package com.github.exceptions
![](./com.github.exceptions.svg)
