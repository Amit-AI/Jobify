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
        {
            display: "Users",
            path: "/users"
        }
    ];

    return (
        <div>
            <Navbar bg="warning" expand="lg" variant="dark" className="py-3">
                <Container>
                    <NavbarBrand className="display-1">JobListing</NavbarBrand>
                    <NavbarToggle />
                    <NavbarCollapse>
                        <Nav>
                          {
                            nav_links.map((item, index)=>
                                <Link className="h2" key={index}><NavLink to={item.path} key={index} className="nav_item">{item.display}</NavLink></Link>
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
