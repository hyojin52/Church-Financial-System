import ContentLayout from "@components/templates/Layout/ContentLayout";
import Title from "@components/organisms/Title/Title";
import {WrapLayout} from "@components/templates/Layout/Layout.styles";

const CategoryList = () => {

    return (
        <WrapLayout>
            <Title title={"항목 관리"}>

            </Title>
            <ContentLayout>
                <div>
                    category
                </div>
            </ContentLayout>
        </WrapLayout>

    );
};

export default CategoryList;