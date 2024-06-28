package com.toniferr.spring6restmvc.services;

import com.toniferr.spring6restmvc.model.BeerCSVRecord;

import java.io.File;
import java.util.List;

/**
 * Created by toniferr.
 */
public interface BeerCsvService {

    List<BeerCSVRecord> convertCSV(File csvFile);
}
