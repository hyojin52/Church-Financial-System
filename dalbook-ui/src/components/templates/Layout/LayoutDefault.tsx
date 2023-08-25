import { Layout } from 'antd';
import {Routes, Route} from 'react-router-dom'
import {allRoutes} from "@common/routes/allRoutes";
import Lnb from "@components/organisms/Lnb/Lnb";
import {EntireLayout} from "@components/templates/Layout/Layout.styles";

const LayoutDefault = () => {

    return (
        <EntireLayout>
            <Lnb />
            <Routes>
                {allRoutes.map(({ path, component, authorization }, key) =>
                    <Route
                        key={key}
                        path={path}
                        Component={component}
                    />
                )}
            </Routes>
        </EntireLayout>
    );
};

export default LayoutDefault;