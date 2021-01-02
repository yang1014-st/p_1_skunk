package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGame {

	@Test
	void test_with_players() {
		Player[] players = new Player[3];
		players[0]=new Player(20,"TestPlayer1");
		players[1]=new Player (20,"TestPlayer2");
		players[2]=new Player (20,"TestPlayer3");
		String[] player_names = {"TestPlayer1","TestPlayer2","TestPlayer3"};
		int number_of_players=2;
		Game game = new Game(players, player_names,3,true);
		
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and2();
		Roll roll = new Roll(dice);
		Turn turn = new Turn();
		game.set_last_turn(turn);
	
		game.set_current_player_number(0);
		game.get_previous_player();
		assertEquals(2,game.get_current_player_number());
		game.get_next_player();
		game.get_next_player();
		assertEquals(1,game.get_current_player_number());
		game.get_previous_player();
		game.get_previous_player();
		assertEquals(2,game.get_current_player_number());

		assertEquals("TestPlayer1",game.get_players()[0].get_name());
		assertEquals("TestPlayer2",game.get_players()[1].get_name());
		assertEquals("TestPlayer3",game.get_players()[2].get_name());

		assertEquals(0,game.get_turn().get_turn_score());
		
		game.get_players()[0].set_game_score(0);
		game.get_players()[1].set_game_score(10);
		game.get_players()[2].set_game_score(20);

		game.get_winners_numbers();
		assertEquals(20,game.get_winner_score());
		
		game.exchange_kitty(20);
		
		assertEquals(10,game.get_players()[0].get_total_chips());
		assertEquals(15,game.get_players()[1].get_total_chips());


		
	}
	
	@Test
	void test_with_predictable_dice_1and1() {
		Player[] players = new Player[3];
		players[0]=new Player(20,"TestPlayer1");
		String[] player_names = {"TestPlayer1"};
		int number_of_players=1;
		Game game = new Game(players, player_names,1,true);
		
		
		PredictableDice dice = new PredictableDice();
		dice.test_with_predictable_die_1and1();
		Roll roll = new Roll(dice);
		Turn turn = new Turn();
		turn.test_set_last_turn(roll);
		game.set_last_turn(turn);
		turn.start_turn();
		
        assertEquals("double skunk",game.get_turn().getLastRoll().get_result_of_check_skunk());

        game.set_wants_to_roll(true);
        game.complete_one_roll_for_one_player(true);
        game.continue_turn();
		assertEquals("TestPlayer1 - Roll1: Double Skunk! You lose the turn. Your turn score is 0. You need to pay 4 chip to the kitty.",game.get_message_after_each_roll());

		game.players_get_reult_after_turn_ends();
		
		assertEquals("TestPlayer1 - Your previous game score is 0. Your game score is 0. You lost 4 chips. You have 16 chips.",game.get_players()[0].get_player_result());
		
	}

}
