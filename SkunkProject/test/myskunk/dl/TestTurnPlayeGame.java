package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myskunk.dl.Dice;
import myskunk.dl.Player;
import myskunk.dl.Roll;
import myskunk.dl.Turn;

class TestTurnPlayeGame {

	@Test
	void test_with_predictable_die_1and1() {
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and1();
		
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		
		Game game = new Game(turn,"Jie");
		game.continue_game(turn);
		
		assertEquals("Roll1: Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.",turn.get_message_after_each_roll());
		assertEquals("Jie - Roll1: Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.",game.get_message_after_each_roll());

		game.get_turn().end_roll();
		game.end_game();
		
		assertEquals(0,turn.get_turn_score());
		assertEquals(1,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(1,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(4,turn.get_chip_number_to_lose());
	   	assertEquals(46,game.get_player().get_number_of_chips());
		assertEquals(0,game.get_player().get_number_of_score());
		assertEquals("Jie - Your scope is 0. You lost 4 chips. You have 46 chips.",game.get_player().get_result());
		assertEquals("Jie - End of the turn. Score for this turn is 0. Chip penality is 4."+"\n"
		+ "Roll1: Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty." + "\n"+"Jie - Your scope is 0. You lost 4 chips. You have 46 chips.", game.get_message_after_each_turn());
	}

	@Test
	void test_with_predictable_die_1and2() {
	
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and2();
		
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		
		Game game = new Game(turn,"Jie");
		game.continue_game(turn);

		
		assertEquals("Roll1: Deuce Skunk! You lose the turn. Your turn score is 0. You need to pay 2 chip to the kitty.",turn.get_message_after_each_roll());
		assertEquals("Jie - Roll1: Deuce Skunk! You lose the turn. Your turn score is 0. You need to pay 2 chip to the kitty.",game.get_message_after_each_roll());

		game.get_turn().end_roll();
		game.end_game();

		assertEquals(0, turn.get_turn_score());
		assertEquals(1,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(2,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(2,turn.get_chip_number_to_lose());
		assertEquals(48,game.get_player().get_number_of_chips());
		assertEquals(0,game.get_player().get_number_of_score());
		assertEquals("Jie - Your scope is 0. You lost 2 chips. You have 48 chips.",game.get_player().get_result());
		assertEquals("Jie - End of the turn. Score for this turn is 0. Chip penality is 2."+"\n"
				+ "Roll1: Deuce Skunk! You lose the turn. Your turn score is 0. You need to pay 2 chip to the kitty." + "\n"+"Jie - Your scope is 0. You lost 2 chips. You have 48 chips.", game.get_message_after_each_turn());
			
	}

	@Test
	void test_with_predictable_die_1and3() {
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and3();
		
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		
		Game game = new Game(turn,"Jie");
		game.continue_game(turn);
		
		assertEquals("Roll1: One Skunk! You lose the turn. Your turn score is 0. You need to pay 1 chip to the kitty.",turn.get_message_after_each_roll());
		assertEquals("Jie - Roll1: One Skunk! You lose the turn. Your turn score is 0. You need to pay 1 chip to the kitty.",game.get_message_after_each_roll());

		game.get_turn().end_roll();
		game.end_game();

		assertEquals(0, turn.get_turn_score());
		assertEquals(1,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(3,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(1,turn.get_chip_number_to_lose());
		assertEquals(49,game.get_player().get_number_of_chips());
		assertEquals(0,game.get_player().get_number_of_score());
		assertEquals("Jie - Your scope is 0. You lost 1 chips. You have 49 chips.",game.get_player().get_result());
		assertEquals("Jie - End of the turn. Score for this turn is 0. Chip penality is 1."+"\n"
		+"Roll1: One Skunk! You lose the turn. Your turn score is 0. You need to pay 1 chip to the kitty."+"\n"+ "Jie - Your scope is 0. You lost 1 chips. You have 49 chips.", game.get_message_after_each_turn());

	}

	@Test
	void test_with_predictable_die_2and3() {
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_2and3();
		
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);

		Game game = new Game(turn,"Jie");
		game.continue_game(turn);
		
		assertEquals("Roll1: 5 => 2 + 3, gives new turn score of 5.",turn.get_message_after_each_roll());
		assertEquals("Jie - Roll1: 5 => 2 + 3, gives new turn score of 5.",game.get_message_after_each_roll());

		game.get_turn().end_roll();
		game.end_game();
		
		assertEquals(5, turn.get_turn_score());
		assertEquals(2,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(3,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(0,turn.get_chip_number_to_lose());
		assertEquals(50,game.get_player().get_number_of_chips());
		assertEquals(5,game.get_player().get_number_of_score());
		assertEquals("Jie - Your scope is 5. You lost 0 chips. You have 50 chips.",game.get_player().get_result());
		assertEquals("Jie - End of the turn. Score for this turn is 5. Chip penality is 0."+"\n"
		+"Roll1: 5 => 2 + 3, gives new turn score of 5." +"\n"+ "Jie - Your scope is 5. You lost 0 chips. You have 50 chips.", game.get_message_after_each_turn());

	}

	@Test
	void test_with_predictable_die_2and3_1and1() {


		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_2and3();

		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);

		Game game = new Game(turn,"Jie");
		game.continue_game(turn);
		
		assertEquals("Roll1: 5 => 2 + 3, gives new turn score of 5.",turn.get_message_after_each_roll());
		assertEquals("Jie - Roll1: 5 => 2 + 3, gives new turn score of 5.",game.get_message_after_each_roll());

		dice = new PredictableDice();
		dice.test_with_predictable_die_1and1();
		
		Roll roll2 = new Roll(dice);
		turn.continue_game(roll2);
		game.continue_game(turn);
		
		assertEquals("Roll2: Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.",turn.get_message_after_each_roll());
		assertEquals("Jie - Roll2: Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.",game.get_message_after_each_roll());

		game.get_turn().end_roll();
		game.end_game();
		
		assertEquals(0, turn.get_turn_score());
		assertEquals(1,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(1,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(4,turn.get_chip_number_to_lose());
		assertEquals(46,game.get_player().get_number_of_chips());
		assertEquals(0,game.get_player().get_number_of_score());
		assertEquals("End of the turn. Score for this turn is 0. Chip penality is 4."+"\n" + 
				"Roll1: 5 => 2 + 3, gives new turn score of 5." + "\n"+
				"Roll2: Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.", turn.get_message_after_each_turn());
		assertEquals("Jie - Your scope is 0. You lost 4 chips. You have 46 chips.",game.get_player().get_result());
		assertEquals("Jie - End of the turn. Score for this turn is 0. Chip penality is 4."+"\n"+"Roll1: 5 => 2 + 3, gives new turn score of 5." + "\n"+
				"Roll2: Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty." + "\n"+"Jie - Your scope is 0. You lost 4 chips. You have 46 chips.", game.get_message_after_each_turn());

	}

	@Test
	void test_with_predictable_die_2and3_3and2() {
	
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_2and3();
		
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		
		Game game = new Game(turn,"Jie");
		game.continue_game(turn);
		
		assertEquals("Roll1: 5 => 2 + 3, gives new turn score of 5.",turn.get_message_after_each_roll());
		assertEquals("Jie - Roll1: 5 => 2 + 3, gives new turn score of 5.",game.get_message_after_each_roll());
		assertEquals(2,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(3,turn.getLastRoll().getDice().getDie2().getLastRoll());
		
		dice = new PredictableDice();
		dice.test_with_predictable_die_3and2();
		
		Roll roll2 = new Roll(dice);
		turn.continue_game(roll2);
		
		
		assertEquals("Roll2: 5 => 3 + 2, gives new turn score of 10.",turn.get_message_after_each_roll());
	    
		assertEquals(10, turn.get_turn_score());
		assertEquals(3,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(2,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(0,turn.get_chip_number_to_lose());
		
		game.get_turn().end_roll();
		game.end_game();
		
		assertEquals(50,game.get_player().get_number_of_chips());
		assertEquals(10,game.get_player().get_number_of_score());
		assertEquals("Jie - Your scope is 10. You lost 0 chips. You have 50 chips.",game.get_player().get_result());
		assertEquals("Jie - End of the turn. Score for this turn is 10. Chip penality is 0." + "\n"
				+"Roll1: 5 => 2 + 3, gives new turn score of 5." + "\n"
				+ "Roll2: 5 => 3 + 2, gives new turn score of 10." +  "\n"+  "Jie - Your scope is 10. You lost 0 chips. You have 50 chips.", game.get_message_after_each_turn());

	}

	@Test
	void test_with_predictable_die_2and3_3and2_2and2() {
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_2and3();
		
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);

		Game game = new Game(turn,"Jie");
		game.continue_game(turn);
		
		dice = new PredictableDice();
		dice.test_with_predictable_die_3and2();
		
		Roll roll2 = new Roll(dice);
		turn.continue_game(roll2);
		
		dice = new PredictableDice();
		dice.test_with_predictable_die_2and2();
		
		Roll roll3 = new Roll(dice);
		turn.continue_game(roll3);
		assertEquals(14, turn.get_turn_score());
		assertEquals(2,turn.getLastRoll().getDice().getDie1().getLastRoll());
		assertEquals(2,turn.getLastRoll().getDice().getDie2().getLastRoll());
		assertEquals(0,turn.get_chip_number_to_lose());
		assertEquals("Roll3: 4 => 2 + 2, gives new turn score of 14.",turn.get_message_after_each_roll());

		game.get_turn().end_roll();
		game.end_game();
		
		assertEquals(50,game.get_player().get_number_of_chips());
		assertEquals(14,game.get_player().get_number_of_score());
		assertEquals("Jie - Your scope is 14. You lost 0 chips. You have 50 chips.",game.get_player().get_result());
		assertEquals("Jie - End of the turn. Score for this turn is 14. Chip penality is 0."+"\n"
		+"Roll1: 5 => 2 + 3, gives new turn score of 5." + "\n"
		+"Roll2: 5 => 3 + 2, gives new turn score of 10." + "\n"
		+"Roll3: 4 => 2 + 2, gives new turn score of 14." + "\n"+ "Jie - Your scope is 14. You lost 0 chips. You have 50 chips.", game.get_message_after_each_turn());

	}
	


	@Test
	void test_with_normal_die_1_roll() {
		Turn turn = new Turn();
		assertFalse(turn.get_turn_score() == 13);
	}

	@Test
	void test_with_predictable_die_2and2_random() {
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_2and2();
		
		Roll roll = new Roll(dice);
		Turn turn = new Turn(roll);
		turn.start_roll();
		int turn_score_1 = turn.get_turn_score();
		turn.continue_game();
		
		assertFalse(turn.get_turn_score() ==turn_score_1);
	}

	@Test
	void test_end_game() {
		Game game = new Game("Jie");
		game.continue_game();
		int turn_score_1 = game.get_turn().get_turn_score();
		game.end_game();
		assertTrue(game.get_turn().get_turn_score() ==turn_score_1);
	}
	
	@Test
	void test_want_to_stop() {
		
		Turn turn = new Turn();
		turn.continue_game();
		int turn_score_1 = turn.get_turn_score();
		turn.want_to_stop();
		assertTrue(turn.get_turn_score() ==turn_score_1);
	}
}

