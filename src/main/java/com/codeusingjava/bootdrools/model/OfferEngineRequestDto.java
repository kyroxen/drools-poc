package com.codeusingjava.bootdrools.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OfferEngineRequestDto {
	private Integer cibil;
	private String bajajStatus;
	private String employmentType;
	private Double income;
	private String incomeProof;
	private Integer bajajSegment;
	private Integer vehiclePrice;

	private Integer roi;
	private String channel;
	private String functionable; // fn(1, 2)
}