package hw6;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import enums.NavService;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;
import java.util.Map;

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
                            return NavService.valueOf(service);
                        }
                )
        );
    }
}