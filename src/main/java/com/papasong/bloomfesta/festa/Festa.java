package com.papasong.bloomfesta.festa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Festa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String alternativeTitle;
    private String creator;
    private String regDate;
    private String collectionDb;
    private String subjectCategory;
    private String subjectKeyword;
    private String extent;
    private String description;
    private String spatialCoverage;
    private String temporalCoverage;
    private String person;
    private String language;
    private String sourceTitle;
    private String referenceIdentifier;
    private String rights;
    private String copyrightOthers;
    private String url;
    private String contributor;
}
