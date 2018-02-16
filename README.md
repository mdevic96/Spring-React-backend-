# Spring-React-backend-

1. Napravis Spring Boot REST servis koji prihvata i vraca JSON.
2. Nad tim REST servisom napravis React GUI koji bi trebalo da bude
    slozeniji od trivijalnih formi input i prikazi neki output, recimo da
    imas paging u nekoj listi necega i slicno, modalne dijaloge i tako to.

Imas 2 nacina da ovo uradis:
Easy way: Sve da ti bude u okviru istog Spring Boot projekta pa da
    ti sve bude lako dostupno da pozoves servise iz GUI-a.
Hard way: Da imas cist Spring Boot REST servis a da GUI deo ima i
    parce Java koda koji ce trcati na serveru, prihvatati requeste sa GUI-a
    i pozivati REST servis kao sto sad trenutno pozivamo 3rd party servise.
