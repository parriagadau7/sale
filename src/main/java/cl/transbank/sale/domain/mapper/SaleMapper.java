package cl.transbank.sale.domain.mapper;

import cl.transbank.sale.data.model.Client;
import cl.transbank.sale.data.model.Product;
import cl.transbank.sale.data.model.Sale;
import cl.transbank.sale.domain.model.ClientDTO;
import cl.transbank.sale.domain.model.ProductDTO;
import cl.transbank.sale.domain.model.SaleDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SaleMapper implements Converter<SaleDTO, Sale> {


    @Override
    public Sale convert(SaleDTO source) {
        Sale sale = new Sale();
        sale.setClient(buildClient(source.getClient(), sale));
        sale.setProducts(buildProducts(source.getProducts(), sale));
        return sale;
    }

    private Client buildClient(ClientDTO clientDTO, Sale sale) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        client.setSale(sale);
        return client;
    }

    private Set<Product> buildProducts(Set<ProductDTO> productDTOS, Sale sale) {
        Set<Product> products = new HashSet<>();
        for (ProductDTO productDTO : productDTOS) {
            products.add(buildProduct(productDTO, sale));
        }
        return products;
    }

    private Product buildProduct(ProductDTO productDTO, Sale sale) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setSale(sale);
        sale.setTotal(buildTotalSale(productDTO, sale));
        return product;
    }

    private double buildTotalSale(ProductDTO productDTO, Sale sale) {
        return sale.getTotal() + (productDTO.getPrice() * productDTO.getQuantity());
    }
}
