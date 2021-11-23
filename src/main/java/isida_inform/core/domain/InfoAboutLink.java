package isida_inform.core.domain;

import java.io.Serializable;
import java.util.Objects;

public class InfoAboutLink implements Serializable {

    private Long id_link;

    private String name_link;

    private String address_link;

    public InfoAboutLink() {
    }

    public InfoAboutLink(Long id_link, String name_link, String address_link) {
        this.id_link = id_link;
        this.name_link = name_link;
        this.address_link = address_link;
    }

    public Long getId_link() {
        return id_link;
    }

    public void setId_link(Long id_link) {
        this.id_link = id_link;
    }

    public String getName_link() {
        return name_link;
    }

    public void setName_link(String name_link) {
        this.name_link = name_link;
    }

    public String getAddress_link() {
        return address_link;
    }

    public void setAddress_link(String address_link) {
        this.address_link = address_link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoAboutLink foundLink = (InfoAboutLink) o;
        return Objects.equals(id_link, foundLink.id_link)
                && Objects.equals(name_link, foundLink.name_link)
                && Objects.equals(address_link, foundLink.address_link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_link, name_link, address_link);
    }

    @Override
    public String toString() {
        return "FoundLink{" +
                "id_link=" + id_link +
                ", name_link='" + name_link + '\'' +
                ", address_link='" + address_link + '\'' +
                '}';
    }
}
