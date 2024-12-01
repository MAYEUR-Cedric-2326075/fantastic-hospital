package fantasticHospital.Creature.Races.Lycanthrope;

import java.util.*;

public class Pack {

    private Couple<Lycanthrope, LycanthropeMale, LycanthropeFemale> couple; // Couple d'Alphas
    private TreeMap<Integer, HashSet<Lycanthrope>> members; // Membres ordonnés selon la clé (1 à 26)
    public LycanthropeFemaleRanking  ranking;
    private static final int best_rank=1;
    private static final int worst_rank=26;
    // Constructeur
    public Pack() {
        this.members = new TreeMap<>();
        this.ranking = new LycanthropeFemaleRanking();
        this.members=Pack.memberInitialisation();
        couple=new Couple<Lycanthrope,LycanthropeMale,LycanthropeFemale>(null,null);
    }
    private static TreeMap<Integer, HashSet<Lycanthrope>> memberInitialisation(){
        TreeMap<Integer, HashSet<Lycanthrope>> members = new TreeMap<>();
        for (int i = best_rank; i <= worst_rank; i++) {
            members.put(i, new HashSet<>());
        }
        return members;
    }

    // Taille du Pack (nombre total de Lycanthropes)
    public int size() {
        return members.values().stream().mapToInt(Set::size).sum();
    }

    // Vérifie si un Lycanthrope est dans le pack
    public boolean isInPack(Lycanthrope lycanthrope) {
        return getKeyByLycanthrope(lycanthrope)!=-1;
    }

    // Retourne l'Alpha Mâle
    public LycanthropeMale getAlphaMale() {
        return couple.getMale();
    }

    // Retourne l'Alpha Femelle
    public LycanthropeFemale getAlphaFemale() {
        return couple.getFemale();
    }


    // Ajoute un Lycanthrope à une clé spécifique
    protected void add(int rank, Lycanthrope lycanthrope) {
        if(members.containsKey(rank)){
            members.get(rank).add(lycanthrope);
        }

    }
    private void add(Lycanthrope lycanthrope) {
        this.add(worst_rank, lycanthrope);
    }

    public void addLycanthrope(LycanthropeMale lycanthrope) {
        this.add(lycanthrope);
    }
    public void addLycanthrope(LycanthropeFemale lycanthrope) {
        this.add(lycanthrope);
        ranking.addLycanthrope(lycanthrope);
    }
    public void addLycanthrope(int rank,LycanthropeMale lycanthrope) {
        this.add(rank,lycanthrope);
    }
    public void addLycanthrope(int rank,LycanthropeFemale lycanthrope) {
        this.add(rank,lycanthrope);
        ranking.addLycanthrope(lycanthrope);
    }


    // Supprime un Lycanthrope d'une clé spécifique
    public void removeLycanthrope(int rank, Lycanthrope lycanthrope) {
        if (members.containsKey(rank)) {
            HashSet<Lycanthrope> lycanthropes = members.get(rank);
            if (lycanthropes != null) {
                lycanthropes.remove(lycanthrope);
            }
        }


    }


    // Supprime un Lycanthrope en cherchant dans toutes les clés
    public void removeLycanthrope(Lycanthrope lycanthrope) {
        for (Map.Entry<Integer, HashSet<Lycanthrope>> entry : members.entrySet()) {
            HashSet<Lycanthrope> lycanthropes = entry.getValue();
            if (lycanthropes != null && lycanthropes.contains(lycanthrope)) {
                lycanthropes.remove(lycanthrope);
                return;
            }
        }
    }


    // Récupère la clé d'un Lycanthrope donné
    public int getKeyByLycanthrope(Lycanthrope lycanthrope) {
        for (Map.Entry<Integer, HashSet<Lycanthrope>> entry : members.entrySet()) {
            if (entry.getValue().contains(lycanthrope))
                return entry.getKey();
        }
        return -1;
    }
    public void moveMembers(int rank,Lycanthrope lycanthrope) {
        int oldRank=getKeyByLycanthrope(lycanthrope);
        add(rank,lycanthrope);
        removeLycanthrope(oldRank,lycanthrope);
    }

    private void swap(int key1,Lycanthrope lycanthrope1,int key2,Lycanthrope lycanthrope2) {
        moveMembers(key1, lycanthrope2);
        moveMembers(key2, lycanthrope1);
    }

    public void swapLycanthrope(LycanthropeMale lycanthrope1, LycanthropeMale lycanthrope2) {
        int key1 = getKeyByLycanthrope(lycanthrope1);
        int key2 = getKeyByLycanthrope(lycanthrope2);
        if(key1!=key2){
            if(key1!=-1&&key2!=-1){
                if(key1==best_rank)
                    couple.setMale(lycanthrope1);
                if(key2==best_rank)
                    couple.setMale(lycanthrope2);
                swap(key1,lycanthrope1,key2,lycanthrope2);
            }
        }

    }
    private void swapLycanthrope(LycanthropeFemale lycanthrope1, LycanthropeFemale lycanthrope2) {
        // Récupérer les clés des deux lycanthropes
        int key1 = getKeyByLycanthrope(lycanthrope1);
        int key2 = getKeyByLycanthrope(lycanthrope2);
        if(key1!=key2){
            if(key1!=-1&&key2!=-1){
                if(key1==best_rank)
                    couple.setFemale(lycanthrope1);
                if(key2==best_rank)
                    couple.setFemale(lycanthrope2);
                swap(key1,lycanthrope1,key2,lycanthrope2);

            }
        }

    }


    protected void updateAlphaFemale() {
        if (ranking.size() > 0) {
            LycanthropeFemale bestFemale = ranking.getFirst();
            if(getAlphaFemale()==null)
                moveMembers(best_rank,bestFemale);
            else{
                if(getAlphaFemale()!=bestFemale){
                    swapLycanthrope(getAlphaFemale(), bestFemale);
                }
            }
            couple.setFemale(bestFemale);
        }
    }


////////////////////////////////////////////////////////////////////////////////////
    protected void updateAlphaMale(LycanthropeMale lycanthrope) {
        if(couple.getMale()==null){
            moveMembers(best_rank,lycanthrope);
            /*
            addLycanthrope(best_rank,lycanthrope);
            members.remove(getKeyByLycanthrope(lycanthrope));

             */
            couple.setMale(lycanthrope);
        }
        else{
            int oldPlace = getKeyByLycanthrope(lycanthrope);
            moveMembers(best_rank,lycanthrope);
            moveMembers(oldPlace,getAlphaMale());
            couple.setMale(lycanthrope);
            System.out.println("test");
            //swapLycanthrope(getAlphaMale(), lycanthrope);

        }
        couple.setMale(lycanthrope);



    }


    private boolean challenge(Lycanthrope challenger, Lycanthrope challenged) {
        if(challenged==null)
            return true;
        if (isInPack(challenger) && isInPack(challenged)) {
            if (challenger.getDomanationFactor() >= challenged.getDomanationFactor()){
                if(challenger.getStrength() > challenged.getStrength()){
                    return true;
                }
                else
                    System.out.println("Pas assez de force");
            }
            else
                System.out.println("Pas assez de facteur");
        }
        else
            System.out.println("Pas dans le pack");
        return false;
    }
    public boolean challenge(LycanthropeMale challenger, LycanthropeMale challenged) {
        if(challenged!=null&&challenger!=null){
            if (challenge((Lycanthrope)challenger,(Lycanthrope)challenged)){
                if(challenged.isAlpha())
                    updateAlphaMale(challenger);
                swapLycanthrope(challenger,challenged);
                return true;
            }
        }
        //System.out.println("CHALNGE EUCHOÉ");
        return false;

    }
    public boolean challenge(LycanthropeFemale challenger, LycanthropeFemale challenged) {
        if (challenge((Lycanthrope)challenger,(Lycanthrope)challenged)){
            if(!challenged.isAlpha()){
                swapLycanthrope(challenger,challenged);
                return true;
            }
        }

        return false;
    }

    public boolean challengeAlpha(LycanthropeMale challenger) {
        if(getAlphaMale()==null){
            updateAlphaMale(challenger);
            updateAlphaFemale();
            return true;
        }
        if(challenge(challenger,getAlphaMale())){
            couple.setMale(getAlphaMale());
            updateAlphaFemale();
            return true;
        }
        //System.out.println("CHALNGE EUCHOÉ");
        return false;

    }

    public  boolean isAlpha(LycanthropeFemale lycanthrope) {
        if(getAlphaFemale()!=null){
            return getAlphaFemale().equals(lycanthrope);
        }
        return false;
    }
    public  boolean isAlpha(LycanthropeMale lycanthrope) {
        if(getAlphaMale()!=null){
            return getAlphaMale().equals(lycanthrope);
        }
        return false;
    }

    // Affiche les informations du pack
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pack {")
                .append("\n  Size: ").append(this.size())
                .append("\n  Alpha Male: ").append(getAlphaMale() != null ? getAlphaMale().toString() : "None")
                .append("\n  Alpha Female: ").append(getAlphaFemale() != null ? getAlphaFemale().toString() : "None")
                .append("\n  Members:");

        for (Map.Entry<Integer, HashSet<Lycanthrope>> entry : members.entrySet()) {
            sb.append("\n    Key ").append(entry.getKey()).append(": ");
            if (entry.getValue().isEmpty())
                sb.append("No members");
            else
            {
                for (Lycanthrope member : entry.getValue())
                    sb.append("\n      ").append(member.toString());

            }
        }
        sb.append("\n}");
        return sb.toString();
    }






}
