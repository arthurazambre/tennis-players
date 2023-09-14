package com.example.tennisplayers;

import com.example.tennisplayers.model.TennisPlayerData;
import com.example.tennisplayers.model.TennisPlayersData;
import com.example.tennisplayers.model.TennisPlayersStats;
import com.example.tennisplayers.service.TennisPlayersService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@SpringBootTest
class TennisPlayersApplicationTests {

	@Mock
	TennisPlayersService tennisPlayersService;

	@Test
	public void testGet() {
		// ARRANGE
		TennisPlayersData tennisPlayersData = new TennisPlayersData();
		TennisPlayerData tennisPlayerData = new TennisPlayerData();
		tennisPlayerData.setFirstname("Nowak");
		tennisPlayersData.setPlayers(List.of(tennisPlayerData));
		Mockito.when(tennisPlayersService.getData()).thenReturn(tennisPlayersData);

		// ACT
		TennisPlayersData result = tennisPlayersService.getData();

		// ASSERT
		assert result.getPlayers().get(0).getFirstname().equals("Nowak");
	}

	@Test
	public void testGetById() {
		// ARRANGE
		TennisPlayerData tennisPlayerData = new TennisPlayerData();
		tennisPlayerData.setFirstname("Nowak");
		Mockito.when(tennisPlayersService.getPlayerData(Mockito.any())).thenReturn(tennisPlayerData);

		// ACT
		TennisPlayerData result = tennisPlayersService.getPlayerData(1L);

		// ASSERT
		assert result.getFirstname().equals("Nowak");
	}

	@Test
	public void testGetStats() {
		// ARRANGE
		TennisPlayersStats tennisPlayersStats = new TennisPlayersStats();
		tennisPlayersStats.setMedianHeight(1.8f);
		Mockito.when(tennisPlayersService.getStats()).thenReturn(tennisPlayersStats);

		// ACT
		TennisPlayersStats result = tennisPlayersService.getStats();

		// ASSERT
		assert result.getMedianHeight() == 1.8f;
	}

}
