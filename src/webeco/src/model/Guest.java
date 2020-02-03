package model;

import static enums.Roles.GUEST;

import enums.Roles;

public class Guest extends AbstractUser{
	




	public Guest(int id, String mail, String name, String username, String pass) {
		super(id, mail, name, username, pass, Roles.GUEST);
		// TODO Auto-generated constructor stub
	}

	@Override
    public Roles getType() {
        return GUEST;
    }

	

	@Override
	public String toString() {
		return "Guest [name=" + name + ", surname=" + surname + ", pass=" + pass + ", mail=" + mail + ", type=" + type
				+ ", cart=" + cart + ", history=" + history + ", boards=" + boards + ", greenCoin=" + greenCoin + "]";
	}

	public void setValid(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	


	
	
    
}
