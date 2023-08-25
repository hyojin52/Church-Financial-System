import {WrapContent} from "@components/templates/Layout/Layout.styles";

const ContentLayout = ({children}) => {
    return (
        <WrapContent>
            {children}
        </WrapContent>
    );
};

export default ContentLayout;