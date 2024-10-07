import BasicMenu from "../components/menu/BasicMenu"

const BasicLayout = ({ children }) => {
    return (
        <div>
            <div>
                <BasicMenu />
            </div>
            <main className=''>
                {children}
            </main>
        </div>
    )
}

export default BasicLayout