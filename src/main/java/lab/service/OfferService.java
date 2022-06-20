package lab.service;


import lab.entity.dto.AddOfferDTO;
import lab.repositories.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void addOffer(AddOfferDTO addOfferModel) {

    }
}
