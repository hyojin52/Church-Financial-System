import {ContentHeader, TitleH1, TitleRow} from "@components/organisms/Title/Title.styles";
import { Col } from 'antd';

const Title = ({title, children}) => {
    return (
        <ContentHeader>
            <TitleRow>
                <Col span={8}>
                    <TitleH1>{title}</TitleH1>
                </Col>
                <Col span={8} offset={8}>
                    {children}
                </Col>
            </TitleRow>
        </ContentHeader>
    );
};

export default Title;
