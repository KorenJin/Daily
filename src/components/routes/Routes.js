import SignIn from "../account/sign-in/SignIn";
import Home from "../home/Home";
import Contact from "../contact/Contact";
import SingAlong from "../apps/sing-along/SingAlong";
import Studies from "../apps/studies/Studies";
import Finance from "../apps/finance/Finance";

const routes = [
    { path: '/', component: Home, name: 'Home', icon: "earth" },
    { path: '/account', component: SignIn, name: 'Account', icon: "black-hole" },
    { path: '/sing-along', component: SingAlong, name: 'Sing-along', icon: "uranus" },
    { path: '/studies', component: Studies, name: 'Studies', icon: "jupiter" },
    { path: '/finance', component: Finance, name: 'Finance', icon: "sun" },
    { path: '/contact', component: Contact, name: 'Contact me', icon: "space-exploration" },
];

export default routes;