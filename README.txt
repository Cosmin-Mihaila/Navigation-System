Mihaila Cosmin-Constantin
325CB

  Am inceput prin a citii graful, punand fiecare strada ca fiind un arc din
acesta. Dupa care din acelasi fisier, am citit restul comenzilor pana la
terminarea fisierului.
  Am construit o clasa abstracta vehicul, dupa care am facut cate o clasa
copil pentru fiecare vehicul(camion etc.).
  Graful este reprezentat printr-o lista de arce(strazi), iar fiecare
strada contine un vector de ambuteiaje aparute pe parcurs pe acea strada.
  De asemenea avem o clasa PriorityQueue ce reprezinta o coada cu prioritate
implementata de mine, unde prioritatea este cea mai mica distanta fata de
nodul sursa folosit la metoda drive.
  In cadrul clasei Graf avem metodele:
1. addStreet ce adauga o strada (primind punctul de start, costul etc.) in
lista de strazi
2. addRestriction ce primeste atributele unei strazi si adauga un ambuteiaj
la vectorul de ambuteiaje al acelei strazi
3. drive, unde se implementeaza algoritmul Dijkstra

  Metoda drive:
La inceput Initializam toate distantele cu Integer.MAX_VALUE si punem in toate
caile punctul de start. Dupa care inseram in coada de prioritati nodul de
plecare. De asemenea avem o variabila found ce retine daca am gasit o cale
de la start catre end.
 Dupa care luam un while cat timp coada noastra este goala. Scoatem un element
din coada. Parcurgem lista de strazi si verificam daca gasim o strada care are
punctul de plecare acelasi cu numele nodului pe care tocmai l-am extras din coada
si daca restrictia de gabarit ne permite sa mergem pe acea strada.
  Verificam daca noua cale catre sfarsitul strazi pe care am gasit-o este mai
scurta decat calea anterioara catre acel punct. In caz afirmativ, actualizam
noua distanta, verificam daca am ajuns la punctul de final primit de functia
drive, si inseram in coada nod-ul de la finalul strazii curente.
  La sfarsit verificam daca found este false, atunci afisam ca nu s-a gasit 
nici o cale intre cele 2 puncte, altfel afisam calea intre cele doua puncte
(start si end primite de functia drive) alaturi de costul drumului.
