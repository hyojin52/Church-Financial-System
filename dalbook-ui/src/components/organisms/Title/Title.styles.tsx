import styled from "styled-components";
import { Layout, Row } from 'antd';
const { Header } = Layout;

export const ContentHeader = styled(Header)`
    display: inline-table;
    padding: 0;
    background-color: #f8f3fc;
`
export const TitleRow = styled(Row)`
    padding: 0 15px;
`;

export const TitleH1 = styled("h1")`
    margin: auto;
`;