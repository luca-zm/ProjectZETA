package logic.Model;

import static logic.Model.Roles.GUEST;

public class Guest extends AbstractUser{

    @Override
    public Roles getType() {
        return GUEST;
    }
}
