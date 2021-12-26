package isida_inform.core.domain;

import java.io.Serializable;
import java.util.Objects;

public class LinkContent implements Serializable {

    private Long id;

    private String domainName;

    private String address;

    public LinkContent() {
    }

    public LinkContent(Long id, String domainName, String address) {
        this.id = id;
        this.domainName = domainName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkContent foundLink = (LinkContent) o;
        return Objects.equals(id, foundLink.id)
                && Objects.equals(domainName, foundLink.domainName)
                && Objects.equals(address, foundLink.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, domainName, address);
    }

    @Override
    public String toString() {
        return "FoundLink{" +
                "id =" + id +
                ", name ='" + domainName + '\'' +
                ", address ='" + address + '\'' +
                '}';
    }
}
