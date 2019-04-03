package hw6;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import enums.NavService;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;
import java.util.Map;

import static enums.NavService.*;

public class ServicesTransformer implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(NavService.class,
                        (Map<String, String> row) -> {
                            String service = row.get("Services");
                            NavService navService;
                            switch (service) {
                                case ("SUPPORT"):
                                    navService = SUPPORT;
                                    break;
                                case ("DATES"):
                                    navService = DATES;
                                    break;
                                case ("SEARCH"):
                                    navService = SEARCH;
                                    break;
                                case ("COMPLEX_TABLE"):
                                    navService = COMPLEX_TABLE;
                                    break;
                                case ("SIMPLE_TABLE"):
                                    navService = SIMPLE_TABLE;
                                    break;
                                case ("USER_TABLE"):
                                    navService = USER_TABLE;
                                    break;
                                case ("TABLE_WITH_PAGES"):
                                    navService = TABLE_WITH_PAGES;
                                    break;
                                case ("DIFFERENT_ELEMENTS"):
                                    navService = DIFFERENT_ELEMENTS;
                                    break;
                                case ("PERFORMANCE"):
                                    navService = PERFORMANCE;
                                    break;
                                default:
                                    navService = null;
                                    break;
                            }

                            return navService;
                        }
                )
        );
    }
}