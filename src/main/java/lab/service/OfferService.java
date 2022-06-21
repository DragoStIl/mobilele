package lab.service;


import lab.entity.Model;
import lab.entity.Offer;
import lab.entity.UserEntity;
import lab.entity.dto.AddOfferDTO;
import lab.entity.mapper.OfferMapper;
import lab.repositories.ModelRepository;
import lab.repositories.OfferRepository;
import lab.repositories.UserRepository;
import lab.user.CurrentUser;
import org.springframework.stereotype.Service;


@Service
public class OfferService {
    private OfferRepository offerRepository;
    private UserRepository userRepository;
    private CurrentUser currentUser;
    private OfferMapper offerMapper;
    private ModelRepository modelRepository;


    public OfferService(OfferRepository offerRepository,
                        UserRepository userRepository,
                        CurrentUser currentUser,
                        ModelRepository modelRepository,
                        OfferMapper offerMapper, ModelRepository modelRepository1) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
        this.modelRepository = modelRepository1;
    }

    public void addOffer(AddOfferDTO addOfferDTO) {
        Offer offer = offerMapper.offerDtoToOfferEntity(addOfferDTO);
        UserEntity seller = userRepository.findByEmail(currentUser.getEmail()).orElseThrow();

        Model model = modelRepository.findById(addOfferDTO.getModelId()).orElseThrow();

        offer.setModel(model);
        offer.setSeller(seller);
        offerRepository.save(offer);

        //TODO CHECK IF THERE IS LOGGED USER
    }
}
