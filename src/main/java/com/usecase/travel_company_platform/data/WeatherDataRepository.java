package com.usecase.travel_company_platform.data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherInfoData,Long>{

}
