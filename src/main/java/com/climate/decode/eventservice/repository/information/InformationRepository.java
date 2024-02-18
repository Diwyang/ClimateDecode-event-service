package com.climate.decode.eventservice.repository.information;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.eventservice.entity.information.Information;

public interface InformationRepository extends JpaRepository<Information, Long> {

	Optional<Information> getByEventId(Integer eventId);
}
