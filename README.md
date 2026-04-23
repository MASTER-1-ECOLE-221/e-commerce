#  E-Commerce Catalogue Module - Architecture Pure Java

Ce projet constitue le premier livrable des fondations d'un moteur E-commerce.

##  Caractéristiques du Projet
- **Zéro Framework :** Ni Spring, ni Lombok. Uniquement du Java 17+.
- **Immuabilité :** Utilisation des `records` Java pour les Value Objects.
- **Encapsulation Stricte :** Pas de setters publics, validations aux constructeurs.
- **Robustesse :** Validations d'objects.

##  Structure du Domaine

### 1. Money (Value Object)
- Stocke le montant (`BigDecimal`) et la devise (`String`).
- **Contraintes :** Montant non négatif (0 autorisé), devises limitées à `EUR` et `FCFA`.
- **Logique :** Addition sécurisée interdisant le mélange de devises.

### 2. SKU (Value Object)
- Stocke la référence entrepôt.
- **Contraintes :** Validation par **Regex** strict (`^[A-Z]{3}-\d{4,6}$`).
- Exemple valide : `TEC-123456`.

### 3. Product (Entity)
- Agrège un `SKU`, un `Name` et un `Money`.
- **Identifiant :** `UUID` généré automatiquement à la création.
- **Comportement :** Méthode `applyDiscount` sécurisée (validation du pourcentage entre 0.1 et 100).
