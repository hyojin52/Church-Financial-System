import React from "react";
import styled from "styled-components"
import {Layout, Button} from "antd";
const {Sider} = Layout;

export const CustomSider = styled(Sider)`
 &&& {
    background-color: #FFFFFF;
  }
`;

export const LnbLogo = styled('div')`
    height: 32px;
    margin: 16px;
    background-color: #000000;
    borderRadius: 6px;
`;

const ButtonDefault = `
    display: inline-flex;
    -webkit-box-align: center;
    align-items: center;
    -webkit-box-pack: center;
    justify-content: center;
    box-sizing: border-box;
    -webkit-tap-highlight-color: transparent;
    outline: 0px;
    margin: 0px;
    cursor: pointer;
    user-select: none;
    vertical-align: middle;
    appearance: none;
    text-decoration: none;
    text-align: center;
    flex: 0 0 auto;
    overflow: visible;
    color: rgb(99, 115, 129);
    transition: background-color 150ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;
    padding: 4px;
    z-index: 1101;
`

export const FoldButton = styled(Button)`
    ${ButtonDefault}
    left: 183px;
`

export const UnFoldButton = styled(Button)`
    ${ButtonDefault}
    left: 64px;
`