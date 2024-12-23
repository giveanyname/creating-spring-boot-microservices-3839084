package com.example.explorecalijpa.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.explorecalijpa.model.Tour;
import com.example.explorecalijpa.model.TourPackage;
import com.example.explorecalijpa.repo.TourPackageRepository;

@Service
public class TourPackageService {
  private TourPackageRepository tourPackageRepository;

  public TourPackageService(TourPackageRepository tourPackageRepository) {
    this.tourPackageRepository = tourPackageRepository;
  }

  public TourPackage createTourPackage(String code, String name) {
    return tourPackageRepository.findById(code)
        .orElse(tourPackageRepository.save(new TourPackage(code, name)));
  }

  public List<TourPackage> lookupAll() {
    return tourPackageRepository.findAll();
  }

  public long total() {
    return tourPackageRepository.count();
  }

  public Optional<TourPackage> findByPackageName(String code) {
    return tourPackageRepository.findById(code);
  }
}
