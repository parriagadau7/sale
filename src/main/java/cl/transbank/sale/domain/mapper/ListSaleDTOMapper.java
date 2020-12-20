package cl.transbank.sale.domain.mapper;

import cl.transbank.sale.data.model.Client;
import cl.transbank.sale.data.model.Product;
import cl.transbank.sale.data.model.Sale;
import cl.transbank.sale.domain.model.ClientDTO;
import cl.transbank.sale.domain.model.ProductDTO;
import cl.transbank.sale.domain.model.SaleDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ListSaleDTOMapper implements Converter<List<Sale>, List<SaleDTO>> {


    @Override
    public List<SaleDTO> convert(List<Sale> source) {
        List<SaleDTO> saleDTOList = new ArrayList<>();
        for (Sale sale : source) {
            saleDTOList.add(buildSale(sale));
        }
        return saleDTOList;
    }

    public SaleDTO buildSale(Sale sale) {
        return SaleDTO.builder()
                .id(sale.getId())
                .created(sale.getCreated())
                .total(sale.getTotal())
                .client(buildClient(sale.getClient()))
                .products(buildProducts(sale.getProducts()))
                .build();
    }

    private ClientDTO buildClient(Client client) {
        return ClientDTO.builder()
                .name(client.getName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();
    }

    private Set<ProductDTO> buildProducts(Set<Product> products) {
        Set<ProductDTO> productDTOS = new HashSet<>();
        for (Product product : products) {
            productDTOS.add(buildProduct(product));
        }
        return productDTOS;
    }

    private ProductDTO buildProduct(Product product) {
        return ProductDTO.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
