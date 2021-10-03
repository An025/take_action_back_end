package com.codecool.projectegrandebackend.model.generated.transport.consumePostDataGenerated;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroundPostInput {

	@JsonProperty("distance")
	private Distance distance;

	@JsonProperty("fuel_efficiency")
	private FuelEfficiency fuel_efficiency;

	public Distance getDistance(){
		return distance;
	}

	public FuelEfficiency getFuelEfficiency(){
		return fuel_efficiency;
	}
//
//	@Override
//	public String toString() {
//		return "GroundPostInput{" +
//				"distance=" + distance +
//				", fuelEfficiency=" + fuel_efficiency +
//				'}';
//	}
}