package myskunk.dl;

public  class Kitty {
private static int kitty_number =0;
protected static void add_kitty(int i) {
	kitty_number = kitty_number+i; 
}
public  static int get_kitty() {
	return kitty_number;
}
} 
