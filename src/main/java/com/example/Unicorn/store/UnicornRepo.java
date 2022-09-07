package com.example.Unicorn.store;

import java.util.ArrayList;
import java.util.List;

public class UnicornRepo {

    private List<Unicorn> unicorns;

    public UnicornRepo() {
        unicorns = new ArrayList<>();

        unicorns.add(new Unicorn(100000L, "Twilight", 4, Colors.RED, true, true));
        unicorns.add(new Unicorn(100001L, "Stardust", 1, Colors.WHITE, false, true));
        unicorns.add(new Unicorn(100002L, "Buttercup", 1, Colors.BLUE, false, false));
        unicorns.add(new Unicorn(100003L, "Sparkles", 9, Colors.RAINBOW, true, false));
    }

    // get one unicorn
    public Unicorn getUnicorn(Long id) {
        for (Unicorn unicorn : unicorns) {
            if (unicorn.getId().equals(id)) {
                return unicorn;
            }
        }
        return null;
    }

    // get all unicorns
    public List<Unicorn> getUnicorns() {
        return unicorns;
    }


    // add a unicorn
    public Unicorn addUnicorn(Unicorn unicorn) {
        Unicorn lastUnicorn = unicorns.get(unicorns.size()-1);
        unicorn.setId(lastUnicorn.getId()+1); // set an id on the new unicorn, should be unique, will be done by the database in future exercises
        unicorns.add(unicorn);
        return unicorn;
    }

    // edit a unicorn
    public Unicorn editUnicorn(Unicorn unicorn) {
        Unicorn unicornToEdit = this.getUnicorn(unicorn.getId());
        if (unicornToEdit != null) {
            unicornToEdit.setId(unicorn.getId());
            unicornToEdit.setName(unicorn.getName());
            unicornToEdit.setAge(unicorn.getAge());
            unicornToEdit.setColor(unicorn.getColor());
            unicornToEdit.setHorn(unicorn.isHorn());
            unicornToEdit.setFlyAble(unicorn.isFlyAble());
        }
        return unicorn;
    }

    // delete a unicorn
    public void deleteUnicorn(Long id) {
        Unicorn unicornToDelete = this.getUnicorn(id);
        if (unicornToDelete != null) {
            unicorns.remove(unicornToDelete);
        }
    }
}
