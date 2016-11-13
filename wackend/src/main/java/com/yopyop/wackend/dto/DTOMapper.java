package com.yopyop.wackend.dto;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yopyop.wackend.model.*;


public class DTOMapper {

    final static Logger logger = LoggerFactory.getLogger("DTOMapper");
    
    public static SubscriptionDTO toSubscriptionDTO(Subscription subscription) {
        SubscriptionDTO subscriptionDto = new SubscriptionDTO();
        subscriptionDto.setId(subscription.getId());
        subscriptionDto.setPrm(subscription.getPrm());

        List<ErlDTO> erlsDto = new ArrayList<>();

        for (Erl erl: subscription.getErls()) {
            ErlDTO erlDto = new ErlDTO();
            erlDto.setId(erl.getId());
            erlDto.setCid(erl.getCid());
            erlDto.setSn(erl.getSn());
            erlsDto.add(erlDto);
        }
        subscriptionDto.setErls(erlsDto);

        return subscriptionDto;
    }

    public static AllowedPairingsDTO toAllowedPairingsDTO(AllowedPairings allowedPairings) {
    	AllowedPairingsDTO allowedPairingsDto = new AllowedPairingsDTO();
    	allowedPairingsDto.setErlCid(allowedPairings.getErlCid());
    	allowedPairingsDto.setSubscriptionId(allowedPairings.getSubscriptionId());

        return allowedPairingsDto;
    }
}