package com.example.javaupskill.model;

import lombok.Data;

@Data
public class SubscriptionStatus
{
    private Boolean subscribedToDailyNewsletter;
    private Boolean subscribedToWeeklyDigest;
    private Boolean subscribedToPromotionalOffers;

}
