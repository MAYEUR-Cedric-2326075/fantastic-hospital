package fantasticHospital.Creature.Behavior;

import java.time.LocalDate;

public interface Fertiled {

    boolean isFertiled();
    void setFertiledBegining(LocalDate fertiledBegining);
    void setFertiledDuration(int durationInDays);
    LocalDate getFertiledBegining();
    LocalDate getFertiledEnd();
    boolean isFertilityActive(LocalDate date);
}
