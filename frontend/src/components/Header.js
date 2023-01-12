import { Container, Nav, Navbar, NavbarBrand, NavLink as Link} from "react-bootstrap";
import NavbarCollapse from "react-bootstrap/esm/NavbarCollapse";
import NavbarToggle from "react-bootstrap/esm/NavbarToggle";
import {NavLink} from "react-router-dom";

function Header() {
    const nav_links = [
        {
            display: "Home",
            path: "/",
        },
        {
            display: "Jobs",
            path: "/jobs",
        },
    ];

    return (
        <div>
            <Navbar bg="light" expand="lg">
                <Container>
                    <NavbarBrand href="to">JobListing</NavbarBrand>
                    <NavbarToggle />
                    <NavbarCollapse>
                        <Nav>
                          {
                            nav_links.map((item, index)=>
                                <Link><NavLink to={item.path} key={index} className="nav_item">{item.display}</NavLink></Link>
                            )
                          }
                        </Nav>
                    </NavbarCollapse>
                </Container>
            </Navbar>
        </div>
    );
}

export default Header;
