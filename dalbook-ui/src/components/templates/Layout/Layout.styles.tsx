import React from "react";
import styled from "styled-components";
import {Layout} from "antd";

export const WrapLayout = styled(Layout)`
    margin: 2em;
    background-color: #f8f3fc;
`

export const EntireLayout = styled(Layout)`
    display: flex;
    min-width: 1440px;
    min-height: 100vh;
    background-color: #f8f3fc;
`

export const WrapContent = styled(Layout)`
    margin: 24px 16px 0;
    overflow: initial;
    background-color: #FFFFFF;
    border-radius: 25px;
`