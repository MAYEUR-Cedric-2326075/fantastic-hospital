/**
 * − attendre (ce qui diminue le moral) ;
 * − hurler (lorsque leur moral est au plus bas) ;
 * − s’emporter (en remplacement d’hurlements qui seraient consécutifs) ;
 * − tomber malade (ce qui ajoute une maladie à la liste de maladies) ;
 * − être soignée (ce qui traite une maladie et redonne du moral) ;
 * − trépasser (s’il devient trop malade).
 */
package fantasticHospital.Creature.Behavior;

import fantasticHospital.Creature.Creature;

public interface Waiter {
    // Méthode pour attendre, ce qui diminue le moral
    void waiting();
}