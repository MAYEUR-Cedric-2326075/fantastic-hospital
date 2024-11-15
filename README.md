# Fantasy Hospital 🏥✨🧛‍♂️🐉

Bienvenue dans **Fantasy Hospital**, l'application de gestion et de simulation d'hôpital fantastique où vous gérez un hôpital magique peuplé de créatures légendaires et mythologiques. Votre mission est de gérer les soins et le bien-être de ces créatures tout en maintenant l'hôpital en bon état. 

## Objectif
En tant que médecin dans un hôpital pour créatures fantastiques, vous devrez gérer un personnel médical, soigner des créatures, faire évoluer leurs maladies, et assurer leur moral et leur santé. Vous devrez également gérer des services médicaux spécialisés, comme des centres de quarantaine et des cryptes pour les créatures mortes-vivantes.

## Outils et Environnement de Développement
- **Outils** : GitHub, Notion
- **IDE** : IntelliJ IDEA, Eclipse
- **Système d'exploitation** : Ubuntu, Windows

## Sommaire

1. [Les Créatures du Fantasy Hospital](#les-créatures-du-fantasy-hospital)
2. [Les Maladies](#les-maladies)
3. [Les Services Médicaux](#les-services-médicaux)
4. [Les Médecins](#les-médecins)
5. [L'Hôpital Fantastique](#l-hôpital-fantastique)
6. [Simulation et Gestion Temporelle](#simulation-et-gestion-temporelle)
7. [Problématiques](#problématiques)
8. [Organisation des Fichiers](#organisation-des-fichiers)

---

## Les Créatures du Fantasy Hospital 🧛‍♀️🧝‍♂️🐺🐉🦇

Les créatures de l'hôpital fantastique sont uniques, avec des caractéristiques propres et des comportements distincts. Voici une liste des créatures disponibles dans l'application, avec leurs attributs communs.

### Caractéristiques des Créatures

| Attribut            | Type     |
|---------------------|----------|
| 😃 Nom             | String   |
| ♂♀ Sexe            | Boolean  |
| ⚖️ Poids           | Double   |
| 📏 Taille          | Double   |
| 🎂 Âge             | Int      |
| 😈 Moral           | Int      |
| 🌿 Maladies        | List<Maladie> |

### Actions des Créatures
Les créatures possèdent des actions qui influencent leur moral et leur état :
- **Attendre** : Diminution du moral.
- **Hurler** : Lorsque le moral est trop bas.
- **S'emporter** : Remplace les hurlements et augmente le risque de contamination.
- **Tomber malade** : Ajoute une maladie à la liste des maladies.
- **Être soignée** : Soigne une maladie et améliore le moral.
- **Trépasser** : Meurt lorsqu’une maladie devient trop grave.

Les créatures ont des comportements spécifiques selon leur type, par exemple :
- Les **elfes** et **vampires** peuvent démoraliser les autres créatures lorsqu'ils trépassent.
- Les **orques**, **hommes-bêtes**, **lycanthropes** et **vampires** peuvent transmettre des maladies à d'autres créatures.
- Les **zombies** et **vampires** peuvent se régénérer après leur trépas.

---

## Les Maladies 🦠

Les créatures peuvent contracter diverses maladies, chacune ayant des caractéristiques spécifiques :

| Nom de la maladie | Abbreviation | Niveau actuel | Niveau max | Létalité |
|-------------------|--------------|---------------|------------|----------|
| MDC               | MDC          | Int           | Int        | Boolean  |
| FOMO              | FOMO         | Int           | Int        | Boolean  |
| DRS               | DRS          | Int           | Int        | Boolean  |
| PEC               | PEC          | Int           | Int        | Boolean  |
| ZPL               | ZPL          | Int           | Int        | Boolean  |

### Actions des Maladies
- **Augmenter ou diminuer** leur niveau.
- **Vérifier si la maladie est létale** : Lorsqu'une maladie atteint son niveau maximum, la créature trépassera.

---

## Les Services Médicaux 🏥🧪

Les services médicaux de l'hôpital sont essentiels pour soigner les créatures. Chaque service médical est dédié à un type de créature spécifique (par exemple, les orques dans le service orque). Voici les caractéristiques des services médicaux :

### Caractéristiques d'un Service Médical

| Attribut                     | Type    |
|------------------------------|---------|
| 🏷 Nom                        | String  |
| 📏 Superficie                 | Double  |
| 🔝 Nombre maximum de créatures | Int     |
| ✅ Nombre de créatures présentes | Int   |
| 💰 Budget                     | String  |

### Types de Services Médicaux
- **Service Standard** : Accueille une créature spécifique (par exemple, orques ou lycanthropes).
- **Centre de Quarantaine** : Gère les créatures contagieuses (ex : zombies, lycanthropes).
- **Crypte** : Gère les créatures régénérantes (ex : vampires, zombies).

### Capacités des Services Médicaux
- **Ajouter ou enlever des créatures**.
- **Soigner les créatures**.
- **Réviser le budget** en fonction des besoins de l'enclos (centres de quarantaine ou cryptes avec des critères supplémentaires).

---

## Les Médecins 🩺👨‍⚕️

Chaque médecin est une créature d’un type donné, et il a la capacité de :
- **Examiner un service médical** : Afficher ses caractéristiques et la liste des créatures présentes.
- **Soigner les créatures** d'un service médical.
- **Réviser le budget** des services médicaux.
- **Transférer des créatures** d'un service à un autre.

### Caractéristiques des Médecins

| Attribut               | Type    |
|------------------------|---------|
| Nom                    | String  |
| ♂♀ Sexe                | Boolean |
| 🎂 Âge                 | Int     |

---

## L'Hôpital Fantastique 🏥✨

Le **Fantasy Hospital** est une entité centrale qui gère plusieurs services médicaux et un personnel de médecins. Il possède les caractéristiques suivantes :

| Attribut                  | Type    |
|---------------------------|---------|
| 🏷 Nom                    | String  |
| 🏥 Nombre maximal de services médicaux | Int |
| 🧑‍⚕️ Médecins             | List<Médecin> |

### Capacités de l'Hôpital
- **Afficher le nombre de créatures** présentes dans l'hôpital.
- **Afficher toutes les créatures** dans les services médicaux.
- **Gérer les événements aléatoires** : Changements dans les maladies, le moral des créatures, les services médicaux et l'état des créatures.

---

## Simulation et Gestion Temporelle ⏳

La simulation se déroule en mode **tour par tour**. À chaque tour, l'état des créatures, des services médicaux et des événements aléatoires est mis à jour. Le joueur, incarnant un médecin, doit intervenir à chaque tour pour gérer l'hôpital de manière efficace.

Chaque tour de simulation peut entraîner des changements dans les maladies des créatures, leur moral, leur état de santé, ainsi que dans le fonctionnement des services médicaux. Les joueurs doivent prendre des décisions stratégiques à chaque tour pour assurer la survie et le bien-être des créatures et l'efficacité des services.

### Actions du Médecin par Tour

À chaque tour, le médecin peut effectuer les actions suivantes :

- **Soigner les créatures** : Chaque médecin peut soigner une ou plusieurs créatures, en fonction de la gravité de leurs maladies et de la disponibilité des ressources.
- **Réviser le budget des services médicaux** : Le médecin peut ajuster le budget alloué aux services médicaux pour s'assurer que les soins sont suffisants et que l'hôpital reste fonctionnel.
- **Transférer des créatures** : En fonction des besoins, les créatures peuvent être transférées d'un service à un autre (par exemple, transférer une créature malade dans un centre de quarantaine ou dans un service spécialisé).
- **Faire face aux aléas** : Chaque tour peut apporter des événements imprévus, comme des épidémies, des accidents, ou des crises de moral parmi les créatures. Le médecin devra réagir pour limiter les dégâts.

Les joueurs doivent agir rapidement et avec discernement à chaque tour pour éviter que des créatures ne meurent ou que des épidémies ne se propagent. Les actions doivent être réfléchies, car chaque tour écoulé peut être crucial pour le bon fonctionnement de l'hôpital fantastique.

---

## Problématiques

Certaines problématiques à résoudre lors de la gestion de l'hôpital incluent :
- Gérer les maladies contagieuses et les créatures mortes-vivantes.
- Maintenir un équilibre entre le budget et les besoins des services médicaux.
- Prendre des décisions stratégiques pour éviter que les créatures ne trépassent avant d'avoir été soignées.

---

## Organisation des Fichiers 📂

Les fichiers sont organisés dans le dossier **/src**. Voici la structure de répertoires :

- **Créatures** : Contient toutes les classes représentant les créatures (`Elfe`, `Orque`, `Vampire`, etc.).
- **Maladies** : Contient les classes représentant les différentes maladies (`MDC`, `FOMO`, etc.).
- **Services Médicaux** : Contient les classes de gestion des services médicaux et des sous-types comme les **Centres de Quarantaine** et les **Cryptes**.
- **Médecins** : Contient la classe `Médecin` et ses actions.
- **Hôpital Fantastique** : Contient la classe principale gérant l'hôpital.

---

Amusez-vous bien en gérant votre **Fantasy Hospital** et en veillant sur les créatures fantastiques ! 🌟
