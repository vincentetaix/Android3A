Projet Android 3A ESIEA

# Présentation:
Projet de 3ème année en JAVA utilisant le concept de MVC, la RecyclerView et une API REST pour afficher la liste des consoles de jeu. 
Mon Github comporte 2 branches développement et une branche master, afin de n'avoir que du code fonctionnel en master.

# Prérequis:

- Tutoriel Android Google
- Tutoriel Github

# Consignes respectés:

- Architecture MVC
- Utilisation d'une API REST
- Affichage des données dans un RecyclerView avec un Adapter
- Utilisation de Picasso pour les images
- Seconde activité affichant le détail d'un objet

# Suppléments:

- API REST fait maison, trouvable à [cette adresse](https://github.com/vincentetaix/Fake_API.github.io)
- Gestion du cache pour un fonctionnement hors connexion
- Toast indiquant une erreur internet si l'app est hors-ligne

# Fonctionnalités:

## Premier écran:
Mon premier écran comporte la Recycler View. 
Elle affiche la liste des console des jeux, avec une image, leur nom et leur fabricant.

<img src="https://github.com/vincentetaix/Android3A/blob/master/apk%201.png" width="250"/>

En cas d'absence de connexion internet, un toaster s'affiche avec le message: "Internet Error" afin de notifier l'utilisateur
Chaque console est clickable, ce qui lance la seconde activité

## Second écran:
Le second écran affiche le détail de la console choisie.

<img src="https://github.com/vincentetaix/Android3A/blob/master/Apk%202.png" width="250"/>

On retrouve le nom, le fabricant, les caractéritiques techniques et l'année de sortie.
On retrouve aussi une photo de la console.

# Conclusion

Ce projet m'a permis de m'initier au développement Android et m'a permis de m'améliorer en JAVA.
