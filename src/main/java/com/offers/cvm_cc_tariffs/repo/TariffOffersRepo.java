package com.offers.cvm_cc_tariffs.repo;

import com.offers.cvm_cc_tariffs.model.TariffOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffOffersRepo extends JpaRepository<TariffOffer, Long> {
}
