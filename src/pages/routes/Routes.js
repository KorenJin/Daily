const Contact = () => <div>Contact Component</div>;
const SignAlong = () => <div>SignAlong Component</div>;
const Studies = () => <div>Studies Component</div>;
const About = () => <div>About Component</div>;
const Finance = () => <div>Finance Component</div>;

const routes = [
    { path: '/account', component: About, name: 'Account', icon: "black-hole" },
    { path: '/sing-along', component: SignAlong, name: 'Sing-along', icon: "uranus" },
    { path: '/studies', component: Studies, name: 'Studies', icon: "jupiter" },
    { path: '/finance', component: Finance, name: 'Finance', icon: "sun" },
    { path: '/contact', component: Contact, name: 'Contact me', icon: "space-exploration" },
];

export default routes;