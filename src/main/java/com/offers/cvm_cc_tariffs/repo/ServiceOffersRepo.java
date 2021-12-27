package com.offers.cvm_cc_tariffs.repo;

import com.offers.cvm_cc_tariffs.model.ServiceOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOffersRepo extends JpaRepository<ServiceOffer, Long> {
}
